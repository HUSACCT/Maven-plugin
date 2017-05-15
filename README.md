# HUSACCT Maven Plugin

## Requirements
* Java 8 or higher
* Maven
* A HUSACCT intended_architecture.xml

## Usage
1. Make a local copy of the HUSACCT source code.  
`git clone https://github.com/HUSACCT/HUSACCT.git`
2. Install HUSACCT in your local maven repository  
`mvn install`
3. Make a local copy of the HUSACCT maven plugin source code.    
`git clone https://github.com/HUSACCT/Maven-plugin.git`
4. Install it in the local maven repository  
`mvn install`
5. Include the config in the pom.xml of your java project and tweak it to your situation. (for more details see the pom.xml of the [sample project](https://github.com/HUSACCT/SaccWithHusacctExample_Maven))
```xml
<plugin>
     <groupId>nl.hu.husacct.mavenplugin</groupId>
     <artifactId>husacct-maven-plugin</artifactId>
     <version>1.0-SNAPSHOT</version>
     <configuration>
         <workspacePath>test/resources/sacc/Game31_WorkspaceHUSACCT.xml</workspacePath>
         <previousViolationsPath>test/resources/sacc/ArchitectureViolations_Game31_All_ImportFile.xml</previousViolationsPath>
         <sourcePaths>
             <sourcePath>src/main/java/nl/hu/husacct/game31/</sourcePath>
         </sourcePaths>
     </configuration>
 </plugin>
```
6. Run the HUSACCT maven command  
`mvn husacct:husacct`



## Configuration parameters  

| Parameter                  	| Type              | Description             	                                                                                | Required 	|
|----------------------------	|----------------   |--------------------------------------------------------------------------------------------------------------|----------	|
| workspacePath                 | File              | Path to the HUSACCT intended architecture.xml                                                             | Required  | 
| sourcePaths                   | List of Strings   | List of sourcepaths to be analyzed by HUSACCT                                                             | Required  | 
| previousViolationsPath        | File              | Path to an optional previous violations.xml                                                               | Optional  |  
| failOnNewViolations           | Boolean           | Should the build fail if there are violations found that are undefined in the previous violations file    | Optional  |
| maxViolations                 | Integer           | A set max number of violations before the build fails                                                     | Optional  |

