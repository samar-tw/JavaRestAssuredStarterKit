# JavaRestAssuredStarterKit

A starter kit for API testing using Java, RestAssured, TestNG, and Gradle.

## Features
- API test automation with RestAssured
- TestNG for test orchestration
- Gradle build system
- Example test cases and data-driven testing
- The tests are based on https://reqres.in/

## Project Structure
- `src/main/java` - Main source code (if any)
- `src/test/java` - Test source code
- `src/test/resources` - Test resources (config, data, templates)
- `build/` - Build output directory
- `build.gradle` - Gradle build file
- `testng.xml` - TestNG suite configuration
- `custom.xml` - Another testng suite configuration

## Getting Started

### Prerequisites
- Java 11 or higher
- Gradle (or use the included wrapper)

### Running Tests

1. **Clone the repository:**
   ```sh
   git clone <repo-url>
   cd JavaRestAssuredStarterKit
   ```
2. **Run tests using Gradle:**
   ```sh
   ./gradlew test -DxApiKey={apikey} -Denv=dev -PsuiteXmlFile={custom.xml || tesng.xml}
   ```

Or on Windows:
   ```sh
   gradlew.bat test -DxApiKey={apikey} -Denv=dev -PsuiteXmlFile={custom.xml || tesng.xml}
   ```
You can replace env value by creating properties file under src/main/resources with env name as prefix, e.g., `dev.properties`, `prod.properties`, etc. The properties file should contain hosturl and similar env specific information.

### Test Reports
- After running tests, reports are available in `build/reports/tests/test/index.html`.
- If you are looking for testNG reports, they can be found in `build/reports/tests/test`.

## Useful Commands
- `./gradlew clean` - Clean build outputs
- `./gradlew test` - Run all tests