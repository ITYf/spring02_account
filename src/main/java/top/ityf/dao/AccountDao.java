package top.ityf.dao;

import top.ityf.domain.Account;

import java.util.List;

/**
 * ClassName:AccountDao
 * Package: top.ityf.dao
 * Description: 账户的持久层接口
 *
 * @Date: 2020/2/4 19:59
 * @Author: YanFei
 */
public interface AccountDao {
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
     * 根据名称查询账户
     *
     * 如果有唯一的一个结果就返回，如果没有结果就返回null
     * 如果结果集超过一个就抛异常
     * */
    Account findAccountByName(String accountName);
}
