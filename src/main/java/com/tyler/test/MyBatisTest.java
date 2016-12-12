package com.tyler.test;

import com.tyler.mapper.FatherMapper;
import com.tyler.mapper.SonMapper;
import com.tyler.pojo.Father;
import com.tyler.pojo.Son;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.input.KeyCode.F;
import static javafx.scene.input.KeyCode.S;
import static javax.swing.UIManager.get;

/**
 * Created by tyler on 2016/12/12.
 */
public class MyBatisTest {
    private SqlSession sqlSession = null;
    @Test
    public void select(){
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            FatherMapper fatherMapper = sqlSession.getMapper(FatherMapper.class);
            Father father = fatherMapper.selectFather(1);
            System.out.println(father.getFname());
            List<Son> sons = father.getSons();
            System.out.println(sons.size());
            for(int i = 0;i<sons.size();i++){
                Son son = sons.get(i);
                System.out.println(son.getSname());
            }
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }
    @Test
    public void insert(){
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            FatherMapper fatherMapper = sqlSession.getMapper(FatherMapper.class);
            Father father = new Father("你好啊");
            //通过回送的fid对son中的fid赋值
            int i = fatherMapper.addFather(father);
            int fid = father.getFid();
            System.out.println(i);

            //先添加Father，在添加Son
            SonMapper sonMapper = sqlSession.getMapper(SonMapper.class);
            Son son1 = new Son(fid,"123");
            Son son2 = new Son(fid,"12333");
            Son son3 = new Son(fid,"3232243");
            List<Son> list = new ArrayList<Son>();
            list.add(son1);
            list.add(son2);
            list.add(son3);
            int j = sonMapper.addSon(list);
            System.out.println(j);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }
    @Test
    public void delete(){
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            SonMapper sonMapper = sqlSession.getMapper(SonMapper.class);
            FatherMapper fatherMapper = sqlSession.getMapper(FatherMapper.class);
            int result1 = sonMapper.deleteSon(2);
            int result2 = fatherMapper.deleteFather(2);
            System.out.println(result1);
            System.out.println(result2);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }
    @Test
    public void updateSon(){
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            SonMapper sonMapper = sqlSession.getMapper(SonMapper.class);
            Son son = new Son();
            son.setSid(2);
            son.setSname("修改了");
            sonMapper.updateSon(son);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }
}
