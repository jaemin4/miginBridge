package com.v02.bridgepro01.bridge.common.status;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public class ControllerFunc {

    //SelectAll 타입 반환 함수
    public <T> ResponseEntity<Map<String, Object>> selectAll(List<T> list, String dataSourceName) {
        if (list != null && !list.isEmpty()) {
            Map<String, Object> result = Map.of(dataSourceName, list);
            System.out.println("안녕");
            return ResponseEntity.ok().body(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    //SelectById 타입 반환 함수
    public ResponseEntity<Map<String, Object>> selectById(Object vo, String dataSourceName) {
        if (vo != null) {
            Map<String, Object> result = Map.of(dataSourceName, vo);
            return ResponseEntity.ok().body(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    //UpdateByDTO 타입 반환 함수
    public ResponseEntity<String> updateByDto(int result, String id) {
        if (result != 0) {
            return ResponseEntity.status(HttpStatus.OK).body("Notification update successfully."+ " UpdatedID : " + id);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update notification info.");
        }
    }

    //InsertByDTO 타입 반환 함수
    public ResponseEntity<String> insertByDto(int result, String id) {
        if (result != 0) {
            return ResponseEntity.status(HttpStatus.OK).body("Notification insert successfully."+ " InsertedID : " + id);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to insert notification info.");
        }
    }




}
