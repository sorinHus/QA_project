@echo off
echo ========================================
echo    Cucumber Test Runner Menu
echo ========================================
echo.
echo Select tests to run:
echo.
echo 1. All Tests
echo 2. Registration Tests Only (@RegPoz and @RegNeg)
echo 3. Login Tests Only (@logPoz and @logNeg)
echo 4. Account Tests Only (@newAcc, @newLoan, @logOut)
echo 5. Positive Tests Only (@RegPoz, @logPoz, @newAcc)
echo 6. Negative Tests Only (@RegNeg, @logNeg)
echo 7. Exit
echo.

set /p choice="Enter your choice (1-7): "

if "%choice%"=="1" (
    echo Running all tests...
    call mvn test -Dcucumber.filter.tags="@RegPoz or @RegNeg or @logNeg or @logPoz or @newAcc or @newLoan or @logOut"
)

if "%choice%"=="2" (
    echo Running Registration tests...
    call mvn test -Dcucumber.filter.tags="@RegPoz or @RegNeg"
)

if "%choice%"=="3" (
    echo Running Login tests...
    call mvn test -Dcucumber.filter.tags="@logPoz or @logNeg"
)

if "%choice%"=="4" (
    echo Running Account tests...
    call mvn test -Dcucumber.filter.tags="@newAcc or @newLoan or @logOut"
)

if "%choice%"=="5" (
    echo Running Positive tests...
    call mvn test -Dcucumber.filter.tags="@RegPoz or @logPoz or @newAcc"
)

if "%choice%"=="6" (
    echo Running Negative tests...
    call mvn test -Dcucumber.filter.tags="@RegNeg or @logNeg"
)

if "%choice%"=="7" (
    echo Exiting...
    exit /b
)

echo.
echo Opening test report...
if exist "Report\CucumberExtentReport.html" (
    start Report\CucumberExtentReport.html
)

echo.
pause