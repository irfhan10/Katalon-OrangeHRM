import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil


WebUI.callTestCase(findTestCase('Dashboard/DashboardPage/VerifikasiElements'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

// Ambil browser aktif dari Katalon
WebDriver driver = DriverFactory.getWebDriver()

// Ambil elemen menu di UI
List<WebElement> menus = driver.findElements(By.xpath('//span[@class="oxd-text oxd-text--span oxd-main-menu-item--name"]'))

// Verifikasi jumlah menu (menggunakan int)
WebUI.verifyEqual(menus.size(), 12)

// Ambil data expected dari Test Data
List<String> expected = []

int totalRows = findTestData('TestDataMenu').getRowNumbers()

for (int i = 1; i <= totalRows; i++) {
    expected.add(findTestData('TestDataMenu').getValue('Menu', i))
}

KeywordUtil.logInfo('Expected menu: ' + expected)

// Loop perbandingan UI vs Test Data
boolean allPassed = true

for (int i = 0; i < menus.size(); i++) {
    String actualText = menus.get(i).getText().trim()

    String expectedText = (expected[i]).trim()

    if (actualText.equals(expectedText)) {
        KeywordUtil.logInfo((('Menu ke-' + (i + 1)) + ' sesuai: ') + actualText)
    } else {
        KeywordUtil.markFailed(((((((('Menu ke-' + (i + 1)) + ' Tidak sesuai! ') + 'Ditemukan: \'') + actualText) + '\', ') + 
            'seharusnya: \'') + expectedText) + '\'')

        allPassed = false
    }
}

// Setelah loop selesai
if (allPassed) {
    KeywordUtil.markPassed('Semua menu sesuai dengan test data!')
} else {
    KeywordUtil.markWarning('Ada menu yang tidak sesuai dengan test data!')
}

WebUI.closeBrowser()

