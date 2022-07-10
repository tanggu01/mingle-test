package jpabook.mingle.Service;

import jpabook.mingle.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Transactional
@SpringBootTest
public class UserTest {

    @Autowired
    EntityManager em;


    @Test
    public void 회원가입() throws Exception { //같은 transaction, 같은 영속성 컨텍스트 하나만 생성
        //given

        User user = new User();
        user.setNickName("kim");

        //when
        em.persist(user);
//        Long savedId = user.getId();
////        Long savedId = memberService.join(user);
//
//        //then
        em.flush(); //===[2]=== flush 로 영속성 컨텍스트에 있는걸 디비에 반영하기.쿼리날림.
//        Assert.assertEquals(user, em.find(User.class, savedId)); //저장한멤버와 찾아온멤버가 같은지 증명
    }


}
