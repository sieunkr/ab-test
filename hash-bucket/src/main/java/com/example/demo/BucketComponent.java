package com.example.demo;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BucketComponent implements BucketUseCase {

    private static int BUCKET_SIZE = 100;

    @Override
    public int getBucketNumberByUUID(String uuid) {


        //TODO: 해당 샘플에서, 버킷 번호를 구하는 방법이 중요하지는 않음
        // 0 ~ 99 의 범위 반환, 동일한 id 인 경우 일관된 값을 반환해 줌

        //return Math.abs(uuid.hashCode()) % 100;

        return Hashing.consistentHash(
                Hashing.sha256().hashString(uuid, Charsets.UTF_8), BUCKET_SIZE
        );
    }
}