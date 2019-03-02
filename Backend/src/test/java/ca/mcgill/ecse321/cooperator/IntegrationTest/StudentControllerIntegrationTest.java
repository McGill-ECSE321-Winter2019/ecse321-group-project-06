package ca.mcgill.ecse321.cooperator.IntegrationTest;

//
//@RunWith(SpringRunner.class)
//@SpringBootTest
////@WebMvcTest
public class StudentControllerIntegrationTest {
//    //@Autowired
//	private MockMvc mvc;
//	private Student testStudent1;
//	private Student testStudent2;
//	private Employer testEmployer;
//	private List<Student> testStudents;
//	private List<CoopTerm> testCoopTerms;
//	private List<Employer> testEmployers;
//	private CoopTerm testCoopTerm;
//	private JacksonTester<List<Student>> Jsonstudent;
//	
//	
//	@MockBean
//	private StudentRepository studentRepo;
//	@MockBean
//	private EmployerRepository employerRepo;
//	@Autowired
//	private StudentService StudentService;
//	@Autowired 
//	private StudentController studentController;
//	@Autowired
//	private EmployerService employerService;
//	@Autowired
//	private CoopTermService coopTermService;
//	@Before
//	public void setup(){
//		MockitoAnnotations.initMocks(this);
//		mvc = MockMvcBuilders.standaloneSetup(studentController).build();
//		JacksonTester.initFields(this, new ObjectMapper());
//		//testEvent.set
//		testStudent1 = new Student();
//		
//		testStudent2 = new Student();
//		testEmployer = new Employer();
//		testCoopTerm = new CoopTerm();
//		testCoopTerm.setEmployer(testEmployer);
//		testCoopTerm.setStudent(testStudent1);
//		testStudents = new ArrayList<>();
//		testCoopTerms = new ArrayList<>();
//		testEmployers = new ArrayList<>();
//		testCoopTerms.add(testCoopTerm);
//		testEmployers.add(testEmployer);
//		testStudents.add(testStudent1);
//		testStudents.add(testStudent2);
//		testEmployer.setCoopUserId(1);
//		testEmployer.setCoopTerm(testCoopTerms);
//		testStudent1.setCoopTerm(testCoopTerms);
//		testStudent2.setCoopTerm(testCoopTerms);
//		}
//	
//	@Test
//	public void canGetStudents() throws Exception{
//		when(studentRepo.findAll()).thenReturn(testStudents);
//		when(employerRepo.findById(anyInt())).thenReturn(testEmployer);
//		when(employerRepo.findAll()).thenReturn(testEmployers);
//		
//		MvcResult result = mvc.perform(get("/employer/1/students"))
//				//.andDo(print())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//				.andExpect(status().isOk())
//				.andReturn();
//		String objAsJson = Jsonstudent.write(testStudents).getJson();
//		String responseContent = result.getResponse().getContentAsString();
//		assertEquals(objAsJson,responseContent);
//	}
}
