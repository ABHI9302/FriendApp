package in.ashokit.api;

import in.ashokit.entity.FriendEntity;
import in.ashokit.service.FriendService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FriendRestController {

    private final FriendService service;

    public FriendRestController(FriendService service) {
        this.service = service;
    }

    @PostMapping("/friend/add")
    public ResponseEntity<FriendEntity> addFriend(
            @RequestBody FriendEntity friend) {

        FriendEntity newEntity = service.addFriendContact(friend);

        if (newEntity != null) {
            return new ResponseEntity<>(newEntity, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/friend/{phoneNumber}")
    public List<Object[]> getFriendsContacts(
            @PathVariable Long phoneNumber) {

        return service.readFriendsContacts(phoneNumber);
    }
}