package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


//public class NetworkClient implements InitializingBean, DisposableBean {
public class NetworkClient  {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출 url = " + url);

    }

    public void setUrl(String url){
        this.url = url;
    }

    public  void connect(){
        System.out.println("connect = " + url);
    }

    public void call(String message){
        System.out.println("call" + url + "message = " + message);
    }

    public void disconnect(){
        System.out.println("close = " + url);
    }
// 초기화 소멸 함수를 호출 하는건 신박하지만,
// 해당 함수이름을 변경하지 못하고, 커스텀 하기 힘들다 요즘은 사용하지 않음
//    @Override
//    public void afterPropertiesSet() throws Exception {
////         의존 관계 끝나면 호출해 주겠다는 뜻이다.
//        System.out.println("NetworkClient.afterPropertiesSet");
//        connect();
//        call("초기화 연결 메시지");
//    }
//
//    @Override
//    public void destroy() throws Exception {
////       close 스프링 컨테이너 내려갈때 bean이 죽을때 호출 된다.
//        System.out.println("NetworkClient.destroy");
//        disconnect();
//    }
}
