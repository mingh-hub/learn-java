package com.mingh.learn.io;

import com.mingh.learn.common.constant.CommonConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * @ClassName ScannerExampleTest
 * @Author Hai.Ming
 * @Date 2021/6/6 23:29
 * @Version 1.0
 * @Description Scanner 测试
 */
@DisplayName("Scanner 测试")
public class ScannerExampleTest {

    @InjectMocks
    private ScannerExample example;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("测试利用 Scanner 扫描文件")
    public void testScanFile() throws Exception {
        example.scanFile(CommonConstants.TEST_PATH_DEFAULT);
    }
}
