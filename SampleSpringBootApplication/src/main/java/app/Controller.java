package app;


//import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping(path = "/getAdditionResult")
    public ResponseEntity<Integer> getDetails(@RequestParam(name = "value1") int value1,
                                              @RequestParam(name = "value2") int value2,
                                              @RequestParam Operation operation){

        //@ApiParam(value = "Operation", allowableValues = "ADDITION,SUBTRACTION,MULTIPLICATION,DIVISION")

         AddValues addValues = new AddValues();
        try{
//            int result = addValues.performAddition(value1, value2);
            int result = 0;
            switch (operation) {
                case ADDITION:
                    result = value1 + value2;
                    break;
                case SUBTRACTION:
                    result = value1 - value2;
                    break;
                case MULTIPLICATION:
                    result = value1 * value2;
                    break;
                case DIVISION:
                    result = value1 / value2;
                    break;
            }
            return ResponseEntity.ok(result);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

}
