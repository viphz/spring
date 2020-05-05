package cn.luban.dao;

public class UserDaoImpl implements UserDao {
    public void query(){
        System.out.println("假装查询数据库");
    }
    public String query(String aa){
        System.out.println(aa);
        return "query aa";
    }
}
