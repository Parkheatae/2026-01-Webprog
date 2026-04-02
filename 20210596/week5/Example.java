public class Example {
    public static void main(String[] args) {
        // 기본 변수 선언
        int age = 25;
        double height = 175.5;
        boolean isStudent = true;

        // 배열 생성 및 초기화
        int[] scores = {85, 90, 78, 92};
        String[] subjects = {"Java", "HTML", "CSS", "JavaScript"};

        // 문자열 생성 및 조작
        String name = "Kim";
        String greeting = "Hello, " + name + "!";
        String info = String.format("%s님은 현재 %d세이고 키는 %.1fcm입니다.", name, age, height);

        // 결과 출력
        System.out.println("=== 기본 변수 출력 ===");
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
        System.out.println("키: " + height);
        System.out.println("학생 여부: " + isStudent);

        System.out.println();
        System.out.println("=== 문자열 조작 결과 ===");
        System.out.println(greeting);
        System.out.println(info);

        System.out.println();
        System.out.println("=== 배열 요소 출력 ===");
        for (int i = 0; i < scores.length; i++) {
            System.out.println(subjects[i] + " 점수: " + scores[i]);
        }

        System.out.println();
        System.out.println("=== 배열 합계 및 평균 ===");
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        double average = (double) sum / scores.length;
        System.out.println("점수 합계: " + sum);
        System.out.println("점수 평균: " + average);
    }
}
