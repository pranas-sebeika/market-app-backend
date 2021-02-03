package sebeikapranas.backend.service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    @Value( "${storage.path}" )
    private String storagePath;

    @Value( "${storage.ui.path}" )
    private String uiStoragePath;

    public String storeFile(MultipartFile image) {
            String newFileName = getUniqueName(image.getOriginalFilename());

            try {
                Path filepath = Paths.get(storagePath, newFileName);
                image.transferTo(filepath);

            } catch (IOException e) {
                e.printStackTrace();
//                throw new FileStorageException("Failed to store file");
            }
        return uiStoragePath.concat(newFileName);
    }

    private String getUniqueName(String fileName) {
        return UUID.randomUUID().toString().concat(".").concat(FilenameUtils.getExtension(fileName));
    }


}
