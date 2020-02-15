package top.ityf.service.impl;

import top.ityf.dao.AccountDao;
import top.ityf.domain.Account;
import top.ityf.service.AccountService;

import java.util.List;

/**
 * ClassName:AccountServiceImpl
 * Package: top.ityf.service.impl
 * Description: 账户的业务层实现类
 * <p>
 * 事务控制应该都是在业务层
 *
 * @Date: 2020/2/4 19:58
 * @Author: YanFei
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        List<Account> accounts = accountDao.findAllAccount();
        return accounts;
    }

    public Account findAccountById(Integer accountId) {

        Account account = accountDao.findAccountById(accountId);
        return account;
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer......");
            //根据名称查询转出账户
            Account source = accountDao.findAccountByName(sourceName);
            //根据名称查询转入账户
            Account target = accountDao.findAccountByName(targetName);
            //转出账户减钱
            source.setMoney(source.getMoney() - money);
            //转入账户加钱
            target.setMoney(target.getMoney() + money);
            //更新转出账户
            accountDao.updateAccount(source);
//            int j = 1 / 0;
            //6、更新转入账户
            accountDao.updateAccount(target);
    }
}
