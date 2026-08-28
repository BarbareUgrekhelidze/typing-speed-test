package com.example.typing_speed_test.service;
import com.example.typing_speed_test.dto.TimeModeResponse;
import com.example.typing_speed_test.model.TimeMode;
import com.example.typing_speed_test.repository.TimeModeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import static com.example.typing_speed_test.utility.TimeModeConverter.toTimeModeResponse;

@Service
public class TimeModeService {

    @Autowired
    private TimeModeRepository timeModeRepository;

    public TimeModeResponse getTimeModeById(Integer id){
        return toTimeModeResponse(timeModeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Time mode with id: " + id + " does not exist.")));
    }

    public TimeModeResponse getTimeModeByTime(Integer time){
        return toTimeModeResponse(timeModeRepository.findByTime(time).orElseThrow(() -> new NoSuchElementException("Time mode with duration: " + time + "s does not exist.")));
    }

    public List<TimeModeResponse> getAllTimeModes(){
        List<TimeMode> timeModes = timeModeRepository.findAll();

        return timeModes.stream().map(timeMode -> {
            return new TimeModeResponse(timeMode.getId(), timeMode.getTime());
        }).collect(Collectors.toList());
    }

}
