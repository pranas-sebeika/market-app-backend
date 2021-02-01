package sebeikapranas.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sebeikapranas.backend.entity.Coin;

@Repository
public interface CoinRepository extends JpaRepository<Coin, Long> {
}
