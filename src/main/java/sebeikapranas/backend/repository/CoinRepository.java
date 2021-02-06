package sebeikapranas.backend.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sebeikapranas.backend.entity.Coin;

@Repository
public interface CoinRepository extends JpaRepository<Coin, Long> {

    Optional<Coin> findByIdAndOwnerId(Long coinId, Long userId);

    List<Coin> findAllByOwner(Long OwnerId);


}
