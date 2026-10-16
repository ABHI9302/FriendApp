package in.ashokit.service;

import in.ashokit.entity.FriendEntity;
import in.ashokit.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FriendService {
    @Autowired
    FriendRepository repository;


    public FriendEntity addFriendContact(FriendEntity friend) {

        Integer  count=repository.checkFriendContact(friend.getPhoneNumber(), friend.getFriendNumber());
        if(count==0) {
            FriendEntity newFriend = repository.saveAndFlush(friend);
            return  newFriend;
        }
        else {
            return null;
        }
    }

    public List<Object[]> readFriendsContacts(Long phoneNumber) {

        return  repository.findFriendsContactNumbers(phoneNumber);
    }

}

