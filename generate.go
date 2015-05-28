package main
import (
    "fmt"
    "strings"
    "os"
    "io/ioutil"
    "log"
)
func check(e error) {
    if e != nil {
        log.Fatal(e)
    }
}
func main() {
    for _, element := range os.Args[1:] {
        modelLowName := element
        modelCapsName := getModelCapsName(modelLowName)
        writeController(modelCapsName, modelLowName)
        writeService(modelCapsName, modelLowName)
    }
}

func getModelCapsName(model string) string {
    return strings.Title(model)
}

func pluralizeModel(model string) string {
    if model[len(model)-1:] == "y" {
        return strings.Replace(model, "y", "ies", 99)
    } else {
        return model + "s"
    }
}

func writeController(modelCaps string, modelLow string) {
    // CREATE PATH FOR NEW CONTROLLER
    filePath := []string{ "src/main/java/travelepsi/Controllers/", modelCaps ,"Controller.java" };
    basePath := "generator/base.controller"
    createAndWriteFile(filePath, basePath, modelCaps, modelLow)
}

func writeService(modelCaps string, modelLow string) {
    // CREATE PATH FOR NEW SERVICE
    filePath := []string{ "src/main/java/travelepsi/Services/", modelCaps ,"Service.java" };
    basePath := "generator/base.service"
    createAndWriteFile(filePath, basePath, modelCaps, modelLow)

}

func createAndWriteFile(filePath []string, basePath string, modelCaps string, modelLow string) {
    var path = strings.Join(filePath, "")

    // CREATE FILE
    file, err := os.Create(path)
    check(err)

    // GET BASE CONTROLLER CONTENT
    replaceInFile(basePath, modelCaps, modelLow, path)

    defer file.Close()
}

func replaceInFile(basePath string, modelCaps string, modelLow string, destinationPath string) {
    fileContent, err := ioutil.ReadFile(basePath)
    check(err)

    // REPLACE WITH GOOD VALUES
    var stringFileContentFirst = strings.Replace(string(fileContent), "{{%CAPSMODEL%}}", modelCaps, 99)
    var stringFileContentFirstCaps = strings.Replace(string(stringFileContentFirst), "{{%CAPSMODELPLUR%}}", pluralizeModel(modelCaps), 99)
    var stringFileContent = strings.Replace(string(stringFileContentFirstCaps), "{{%LOWMODEL%}}", modelLow, 99)
    var stringFileContentCaps = strings.Replace(string(stringFileContent), "{{%LOWMODELPLUR%}}", pluralizeModel(modelLow), 99)

    err = ioutil.WriteFile(destinationPath, []byte(stringFileContentCaps), 0644)
    check(err)

    // SUCCESS AND CLOSE FILE
    fmt.Printf("created %s \n", destinationPath)
}
