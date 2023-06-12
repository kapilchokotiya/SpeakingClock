package com.SpeakingClock.Controller;

import com.SpeakingClock.Entity.TimeRequest;
import com.SpeakingClock.Service.TimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class TimeController {
    private final TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @RequestMapping(value = "/current-time", method = RequestMethod.GET)
    public ResponseEntity<String> getCurrentTimeInWords() {
        String currentTimeInWords = timeService.getCurrentTimeInWords();
        return ResponseEntity.ok(currentTimeInWords);
    }

    @RequestMapping(value = "/convert-time", method = RequestMethod.POST)
    public ResponseEntity<String> convertTime(@RequestBody @Valid TimeRequest timeRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String error = bindingResult.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(error);
        }

        String convertedTimeInWords = timeService.convertToWords(timeRequest.getTimeInput()).trim(); // Trim leading and trailing spaces
        return ResponseEntity.ok(convertedTimeInWords);
    }

}


