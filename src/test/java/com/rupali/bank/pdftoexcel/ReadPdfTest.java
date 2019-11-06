package com.rupali.bank.pdftoexcel;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ReadPdfTest {

    @Value("${files.location}")
    String filesLocation;

    @Test
    public void pdfReadTest(){

    }
}
