package com.springioc.scope;

import com.springioc.Dao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("dao")
@Scope("prototype")
public class DaoScopeImpl implements Dao {
    public void test() {
        System.out.println("scope impl");
    }
}
