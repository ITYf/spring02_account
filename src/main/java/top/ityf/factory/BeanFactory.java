package top.ityf.factory;

import top.ityf.service.AccountService;
import top.ityf.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ClassName:BeanFactory
 * Package: top.ityf.factory
 * Description: 用于创建Service的代理对象的工厂
 *
 * @Date: 2020/2/9 11:08
 * @Author: YanFei
 */
public class BeanFactory {
    private AccountService accountService;

    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public final void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 获取Service的代理对象
     */
    public AccountService getAccountService() {
        return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue = null;
                        try {
                            //1、开启事务
                            txManager.beginTransaction();
                            //2、执行操作
                            returnValue = method.invoke(accountService, args);
                            //3、提交事务
                            txManager.commit();
                            //4、返回结果
                            return returnValue;
                        } catch (Exception e) {
                            //5、回滚操作
                            txManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            //6、释放连接
                            txManager.release();
                        }
                    }
                });
    }
}
