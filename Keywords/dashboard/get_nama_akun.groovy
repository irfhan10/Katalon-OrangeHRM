package dashboard

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration
import internal.GlobalVariable
import org.apache.commons.io.FileUtils as FileUtils
import java.io.File as File
import java.text.SimpleDateFormat

public class get_nama_akun {

	@Keyword
	def generatedFileAccount(String nama) {
		try {
			// Buat folder otomatis
			String folderPath = RunConfiguration.getProjectDir() + "/GetNamaUser"
			File folder = new File(folderPath)
			if (!folder.exists()) {
				folder.mkdirs()
				KeywordUtil.logInfo("Folder 'GetNamaUser' dibuat di: " + folderPath)
			}

			// Buat nama file dengan timestamp
			String timestamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date())
			String fileName = "${nama}_${timestamp}.txt"
			File file = new File(folderPath + "/" + fileName)

			// Tulis nama ke file
			FileWriter writer = new FileWriter(file)
			writer.write(nama)
			writer.close()

			KeywordUtil.logInfo("File berhasil dibuat: " + file.getAbsolutePath())
		} catch (IOException e) {
			KeywordUtil.markFailed("Gagal membuat file: " + e.message)
		}
	}
}

