import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class MAINMaticenjePravnogLicaTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private LanguagePage languagePage;
    private OrganizationPage organizationPage;
    private GeneralInformationPage generalInformationPage;
    private AMLScore amlScore;
    private RegistrationDocumentPage registrationDocumentPage;
    private LegalAddressPage legalAddressPage;
    private LandlinePhonePage landlinePhonePage;
    private EmailPage emailPage;
    private TaxProfilePage taxProfilePage;
    private CustomerSegmentPage customerSegmentPage;
    private OrganizationProfilePage organizationProfilePage;
    private RepresentativePage representativePage;
    private OwnerPage ownerPage;
    private BeneficialOwnerPage beneficialOwnerPage;
    private KYCFormPage kycFormPage;
    private UploadDocumentsTask uploadDocumentsTask;
    private UploadSignedDocumentsPage uploadSignedDocumentsPage;
    private ValidityDataPage validityDataPage;




    @Before

    public void setup() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        languagePage = new LanguagePage(driver);
        organizationPage = new OrganizationPage(driver);
        generalInformationPage = new GeneralInformationPage(driver);
        amlScore = new AMLScore(driver);
        registrationDocumentPage = new RegistrationDocumentPage(driver);
        legalAddressPage = new LegalAddressPage(driver);
        landlinePhonePage = new LandlinePhonePage(driver);
        emailPage = new EmailPage(driver);
        taxProfilePage = new TaxProfilePage(driver);
        customerSegmentPage = new CustomerSegmentPage(driver);
        organizationProfilePage = new OrganizationProfilePage(driver);
        representativePage = new RepresentativePage(driver);
        ownerPage = new OwnerPage(driver);
        beneficialOwnerPage = new BeneficialOwnerPage(driver);
        uploadDocumentsTask = new UploadDocumentsTask(driver);
        uploadSignedDocumentsPage = new UploadSignedDocumentsPage(driver);
        validityDataPage = new ValidityDataPage(driver);
        kycFormPage = new KYCFormPage(driver);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikola.becanovic\\Desktop\\KYC\\KYC Form.pdf");

    }


    @Test
    public void testMaticenjePravnogLica() throws Exception {

        loginPage.login("nikola.becanovic", "Test123456#");
        System.out.println("Korisnik je uspješno ulogovan.");

        languagePage.changeLanguageToSerbian();
        System.out.println("Korisnik je uspješno promijenio jezik");

        organizationPage.startOrganizationEnrollment();
        System.out.println("Korisnik je uspješno započeo proces matičenja pravnog lica. ");

        generalInformationPage.enterGeneralInformation("21914240", "TESTFIRMA", "TESTFIRMA", "1. 1. 1970.");
        System.out.println("Korisnik je uspješno unio osnovne podatke.");

        //AML score

        amlScore.completeAML();

        //registration document forma

        registrationDocumentPage.enterRegistrationDocumentNumber("12ds3223e12");
        registrationDocumentPage.enterIssuingDate("1. 3. 2023.");
        registrationDocumentPage.clickCompleteButton();
        System.out.println("Korisnik je uspješno popunio Registration Document formu.");

        legalAddressPage.enterMesto("NOVI SAD");
        legalAddressPage.clickPopUp();
        legalAddressPage.enterStreet("AKSENTIJA MAKSIMOVIĆA");
        legalAddressPage.enterBuildingNo("188");
        legalAddressPage.clickCompleteButton();
        System.out.println("Korisnik je uspješno popunio adresu");

        landlinePhonePage.enterAreaCode("13");
        landlinePhonePage.enterNumber("1243435");
        landlinePhonePage.clickCompleteButton();
        System.out.println("Korisnik je uspješno popunio broj telefona.");

        emailPage.enterEmail("rere2@re.re");
        emailPage.clickCompleteButton();
        System.out.println("Korisnik je uspješno popunio email adresu.");

        taxProfilePage.enterTaxNumber("113692604");
        taxProfilePage.clickCompleteButton();
        System.out.println("Korisnik je uspješno unio PIB");
        taxProfilePage.clickCompleteButton();

        customerSegmentPage.enterCustomerSegment("No segment");
        customerSegmentPage.selectNoSegment();
        customerSegmentPage.clickCompleteButton();
        System.out.println("Korisnik je uspješno dodao segment.");

        organizationProfilePage.selectOwnershipKindPrivateEntity();
        organizationProfilePage.selectLegalStructureDOO();
        organizationProfilePage.enterDelatnost("0000");
        organizationProfilePage.selectOrganizationSizeMicro();
        organizationProfilePage.selectResidentalStatusNotClassified();
        organizationProfilePage.clickCompleteButton();
        //unos zakonskog zastupnika, vlasnika i stvarnog vlasnika

        representativePage.enterRepresentative("Julijan T ", "1. 3. 2023.");
        ownerPage.addOwner("Julijan T ", "100");
        beneficialOwnerPage.enterBeneficialOwner("Test Test");

        // Test KYC form

        kycFormPage.clickKycTask();
        kycFormPage.enterPitanjeBR3("YES");
        kycFormPage.enterPitanjeBR4("Serbia");
        kycFormPage.selectPitanjeBR2();
        kycFormPage.selectPitanjeBR1();
        kycFormPage.selectPitanjeBR6();
        kycFormPage.clickCompleteButton();

        //Klika na task upload signed documents

        uploadDocumentsTask.openUploadSignedDocuments();

        // Test Upload signed documents
        uploadSignedDocumentsPage.clickUploadSignedDocument();
        uploadSignedDocumentsPage.clickKycForm();
        uploadSignedDocumentsPage.clickDragAndDrop();
        uploadSignedDocumentsPage.uploadDocument("C:\\Users\\nikola.becanovic\\Desktop\\KYC\\KYC Form.pdf");
        System.out.println("Korisnik je uspješno uploadovao KYC formu.");

        // Test Validity data
        validityDataPage.clickValidityDataTask();
        validityDataPage.clickCompleteButton();
        validityDataPage.clickValidityDataUpload();
        validityDataPage.clickDragAndDropValidity();
        validityDataPage.uploadValidityData("C:\\Users\\nikola.becanovic\\Desktop\\KYC\\KYC Form.pdf");
        System.out.println("Klijent je uspješno umatičen.");
    }


}
