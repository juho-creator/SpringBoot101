package me.juhokim.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuizController {
    // Response on GET Request
    @GetMapping("/quiz")
    public ResponseEntity<String> quiz(@RequestParam int code){
        switch (code){
            case 1:
                // Created!
                return ResponseEntity.created(null).body("Created!");

            case 2:
                // Bad Request!
                return ResponseEntity.badRequest().body("Bad Request!");

            default:
                // OK!
                return ResponseEntity.ok().body("Ok!");

        }
    }

    // Response on POST Request
    @PostMapping("/quiz")
    public ResponseEntity<String> quiz2(@RequestBody Code code){
        switch (code.value()){
            case 1:
                // Forbidden
                return ResponseEntity.status(403).body("Forbidden!");
            default:
                // OK!
                return ResponseEntity.ok().body("Ok!");

        }
    }
}


record Code(int value) {}