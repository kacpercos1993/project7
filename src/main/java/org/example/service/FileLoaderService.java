package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.strategy.BuildingStrategy;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileLoaderService {
    private static final int BATCH_SIZE = 1000;
    private final BuildingStrategy buildingStrategy;


//    public void loadData(MultipartFile file) {
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
//            List<? extends Person> batch = new ArrayList<>(BATCH_SIZE);
//
//            reader.lines()
//                    .skip(1)
//                    .map(line -> line.split(","))
//                    .map(data -> Person.builder())
//        }
//    }
}
