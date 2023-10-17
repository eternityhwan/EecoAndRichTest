package com.assignment.ecoandrichtest;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class StudyTest {

    //@DisplayNameGeneration() // 클래스와 메서드에 사용가능, 어떤식으로 이름을 지정할지 지정
    //@DisplayName  콘솔에 표기할 테스트 이름 지정한다.(지정하지 않으면 메서드 이름으로 표기한다)

    //@Disabled -- 이 테스트를 실행하지 말라는 표시
    @Test
    @DisplayName("스터디 만들기 \uD83D\uDE31")
    void create_new_study() {
        // 테스트 시간이 얼마나 걸리는지 확인하는 테스트.
        // assertTimeoutPreemptively 100밀리세턴이 끝나면 메서드 끝났으면좋겠다하면 쓰는 메서드
       assertTimeout(Duration.ofSeconds(100), () -> {
           new Study(10);
           Thread.sleep(300);
       });
    }

        // 모든 연관 테스트를 한번에 실행하는 방법 asserAll로 묶는다.
//        assertAll(
//                // 이렇게 만들어놓으면 세 메서드를 한 번에 실행시킬 수 있어.
//                () -> assertNotNull(study),
//                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(),
//                        () -> "스터티를 처음 만들면 " + StudyStatus.DRAFT + " 상태다."),
//                () -> assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원")
//        );
//    }

    @BeforeAll // 반드시 static void로 시작해야해
    static void beforeAll() {
        System.out.println("테스트를 실행하기전에 딱 한 번 실행되는 BeforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("모든 테스트가 실행된 이후 딱 한 번 실행되는 AfterAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("모든 테스트를 실행할 때 각각의 테스트를 실행하기 이전과 이후에 실행된다(each)");
    }

    @AfterEach
    void afterEach() {
        System.out.println("모든 테스트를 실행할 때 각각의 테스트를 실행하기 이전과 이후에 실행된다(each)");
    }
}

//    assertNotNull(study);
//        System.out.println("create");
//        // study가 만들어지면 상태가 draft인 상태여야한다.
//        // 실무에서 몇달 뒤에 테스트 코드가 돌아가는데 실패가 나면 디버깅이 쉽다.
//        // (기대하는 값, 실제 나오는값)
//        assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 처음 만들면 상태값이 DRAFT 여야 한다.");
//        // 아래처럼 람다로 간추릴 수 있어, 오류 생겼을 때 메세지 만들기가 쉬워서 이렇게 한다.
//        assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 DRAFT 상태이다");
//        assertTrue(1<2);
//        assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 한다");
//    }
