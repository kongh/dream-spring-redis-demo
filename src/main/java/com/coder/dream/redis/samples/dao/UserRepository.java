package com.coder.dream.redis.samples.dao;

import com.coder.dream.redis.samples.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.SortParameters;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.core.query.*;
import javax.inject.Named;
import java.util.List;

/**
 * �û��־ò�
 */
@Named
public class UserRepository {

//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String,User> redisTemplate;

    /**
     * ����
     *
     * @param user
     */
    public void save(User user){
        HashOperations<String, Object, Object> opsForHash = redisTemplate.opsForHash();
        opsForHash.put(User.class.getName(), user.getId(), user);
    }

    /**
     * ɾ��
     *
     * @param id
     */
    public void delete(Integer id){
        HashOperations<String, Object, Object> opsForHash = redisTemplate.opsForHash();
        opsForHash.delete(User.class.getName(), id);
    }

    /**
     * �޸�
     *
     * @param user
     */
    public void update(User user){

    }

    /**
     * ����һ��
     *
     * @param id
     * @return
     */
    public User findOne(Integer id){
        HashOperations<String, Object, Object> opsForHash = redisTemplate.opsForHash();
        return (User) opsForHash.get(User.class.getName(),id);
    }

    /**
     * �б�
     *
     * @return
     */
    public List<User> list(){
        HashOperations<String, Object, Object> opsForHash = redisTemplate.opsForHash();
        return (List)opsForHash.values(User.class.getName());
    }

    /**
     * ��ҳ�б�
     *
     * @return
     */
    public List<User> page(){
        SortQueryBuilder<String> sortQueryBuilder = SortQueryBuilder.sort(User.class.getName());
        sortQueryBuilder.limit(0,20);
        sortQueryBuilder.order(SortParameters.Order.ASC);
        SortQuery<String> query = sortQueryBuilder.build();
        SetOperations<String, User> opsForSet = redisTemplate.opsForSet();
        User user = new User();
        opsForSet.add(User.class.getName(),user);
        return redisTemplate.sort(query);
    }

    public void test(User user){
        ListOperations<String, User> opsForList = redisTemplate.opsForList();
        opsForList.rightPush(User.class.getName()+"_list",user);

        opsForList.range(User.class.getName()+"_list",0,100);
    }
}
