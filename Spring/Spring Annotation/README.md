# Spring Annotation 정리



### 1. Basic Annotation

- `@Bean`

- `@ComponentScan(basePackages = {"com.ssafy"})`

- `@Configuration`  : Bean 클래스 설정파일

- `@Component`

  - `@Controller`

  - `@Service`

  - `@Repositroy`

- `@Scope("singleton")` : singleton 이 default, prototype도 사용 가능

- `@Autowired` : 생성자주입, 세터주입, method 주입, 필드 주입 4가지 방식 존재



---

### 2. Front Controller Annotation

- `@RequestMapping("/bookapi/*")`: 지정된 url로 매핑
- `@RequestMapping(value="/user/{userid}")` : `@PathVariable` 사용시
  - `@GetMapping`
  - `@PutMapping`
  - `@PostMapping`
  - `@DeleteMapping`

---

### 3. AOP Annotation

- `@Aspect` : aop 설정파일, Pointcut
- `@Before` : methd 실행하기 전에 수행
- `@AfterReturning` 
- `@AfterThrowing`
- `@After `
- `@Around` : 왔다갔다 귀찮으니까 method안에 한번에 다 써놓는다. proceed를 통해서 분리





---



### 4. Parameter Annotation

- `@RequestParam `
- `@PathVariable`
- `@ModelAttribute User user`

- `@Transactional` : 등록하는 일련의 작업 중 문제가 하나라도 발생하면 자동으로 roll back







---



### 5. REST API Annotation

- `@ResponseBody` : 넘어갈 화면이 아니라 데이터라고 명시
- `@RestController` : 이 Controller안에 있는 method는 모두 data전송을 위한 함수이다.
- `@CrossOrigin(*)` : 등록된 도메인만 접근 가능하다. 허용하고 싶은 도메인 주소만 적용
- `@RequestBody MemberDto memberDto` : 사용자가 나한테 데이터를 넘겨줬을 때, json



---



### 6. Swagger Annotation

- `@EnableSwagger2 @Api("어드민 컨트롤러 API V1") `

- `@ApiOperation(value="회원목록", notes="회원의 전체목록을 반환해 줍니다.") `

- ``` java
  @ApiResponses({    
    @ApiResponse(code=200, message="회원목록 OK"),    
    @ApiResponse(code=404, message="페이지없어"),    
    @ApiResponse(code=500, message="서버에러") })
  @ApiModel(value = "MemberDto : 회원정보", description = "회원의 아이디, 이름, 비번, 가입일등을 설정") 
  public class MemberDto {    
  	@ApiModelProperty(value = "회원 아이디")   
   	private String userid;
  }
  ```



---



### 7. Spring Boot Annotation


- @SpringBootApplication
- @SpringBootConfiguration
- @EnableAutoConfiguration
- @ComponentScan



