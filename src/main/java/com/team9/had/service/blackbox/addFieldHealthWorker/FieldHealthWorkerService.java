package com.team9.had.service.blackbox.addFieldHealthWorker;

import com.team9.had.entity.FieldHealthWorker;

import java.util.List;

public interface FieldHealthWorkerService {
    boolean addFhw(FieldHealthWorker fieldHealthWorker);

    boolean addFhws(List<FieldHealthWorker> fieldHealthWorkers);
}
