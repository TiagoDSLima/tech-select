package com.br.tggp.techselect.service;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class MinioService {

    private final MinioClient minioClient;
    private static final String BUCKET = "tech-select";

    public String subirArquivo(String nomeObjeto, InputStream stream, String contentType) throws Exception {
        minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(BUCKET)
                        .object(nomeObjeto)
                        .stream(stream, -1, 10485760)
                        .contentType(contentType)
                        .build()
        );

        return String.format("http://localhost:9100/%s/%s", BUCKET, nomeObjeto);
    }

    public InputStream downloadArquivo(String nomeObjeto) throws Exception {
        return minioClient.getObject(
                GetObjectArgs.builder()
                        .bucket(BUCKET)
                        .object(nomeObjeto)
                        .build()
        );
    }
}
