package top.ityf.service;

import top.ityf.domain.Account;

import java.util.List;

/**
 * ClassName:AccountService
 * Package: top.ityf.service
 * Description: 账户的业务层接口
 *
 * @Date: 2020/2/4 19:51
 * @Author: YanFei
 */
public interface AccountService {
    /**
     * 查询所有
     * */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     * */
    void saveAccount(Account account);

    /**
     * 更新
     * */
    void updateAccount(Account account);

    /**
     * 删除
     * */
    void deleteAccount(Integer accountId);

    /**
     * 转账
     * @param sourceName  转出的账户名称
     * @param targetName  转入的账户名称
     * @param money       转账金额
     * */
    void transfer(String sourceName,String targetName,Float money);
}
