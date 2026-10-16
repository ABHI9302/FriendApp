package in.ashokit.repository;

import in.ashokit.entity.FriendEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface FriendRepository extends JpaRepository<FriendEntity, Integer> {

    // Changed table name from FRIEND to friend_entity
    @Query(value="SELECT COUNT(*) FROM friend_entity WHERE PHONE_NUMBER=? AND FRIEND_NUMBER=?", nativeQuery=true)
    Integer checkFriendContact(Long phoneNumber, Long friendNumber);

    // Changed table name from FRIEND to friend_entity
    @Query(value="SELECT FRIEND_NUMBER, FRIEND_NAME FROM friend_entity WHERE PHONE_NUMBER=?", nativeQuery=true)
    List<Object[]> findFriendsContactNumbers(Long phoneNumber);
}
