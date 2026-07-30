$ErrorActionPreference = "Stop"

$buildDirectory = Join-Path $PSScriptRoot "build\classes"
New-Item -ItemType Directory -Force -Path $buildDirectory | Out-Null

$sources = @(
    Get-ChildItem -LiteralPath (Join-Path $PSScriptRoot "src") -Recurse -Filter *.java |
        ForEach-Object { $_.FullName }
)

javac -encoding UTF-8 -d $buildDirectory $sources
if ($LASTEXITCODE -ne 0) {
    exit $LASTEXITCODE
}

java -ea -cp $buildDirectory com.angelesco.oop.OopTest
exit $LASTEXITCODE
