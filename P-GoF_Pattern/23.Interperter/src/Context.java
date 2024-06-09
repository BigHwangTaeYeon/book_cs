import java.util.StringTokenizer;

public class Context {
    // 스크립트 문자열에 대해 공백을 기준으로 분리할 수 있는 객체를 필드로 추가
    private StringTokenizer tokeninzer;
    // 현재 뽑아낸 구문을 저장
    private String currentKeyword;

    public Context(String script) {
        tokeninzer = new StringTokenizer(script);
        readNextKeyword();
    }

    public String readNextKeyword() {
        // 공백 문자를 기준으로 구문에 대한 단어를 가지고 있는지 확인
        if (tokeninzer.hasMoreTokens()) {
            // 있으면, 다음 단어를 얻어 currenKeyword에 저장
            currentKeyword = tokeninzer.nextToken();
        } else {
            // 아니면, null 값으로 지정
            currentKeyword = null;
        }
        return currentKeyword;
    }

    public String getCurrentKeyword() {
        return currentKeyword;
    }

}
