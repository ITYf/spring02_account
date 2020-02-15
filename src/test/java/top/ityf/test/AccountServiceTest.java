package top.ityf.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.ityf.domain.Account;
import top.ityf.service.AccountService;

import java.util.List;

/**
 * ClassName:AccountServiceTest
 * Package: top.ityf.test
 * Description: 使用junit单元测试，测试我们的配置
 *
 * @Date: 2020/2/4 21:25
 * @Author: YanFei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {
    @Autowired
    @Qualifier("proxyAccountService")
    private AccountService as;

    @Test
    public void testTransfer(){
        as.transfer("test1","test",100f);
    }
}
