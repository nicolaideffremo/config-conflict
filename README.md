# Config Conflict Reproducer

Reproducer for observed issue leading to https://quarkusio.zulipchat.com/#narrow/channel/187030-users/topic/Pass.20quarkus.2Eclass-loading.2Eremoved-resources.20to.20Maven.20plugin/with/573687608

## Prerequisites

- JDK 17
- Quarkus 3.27.2

## Project Structure

This is a multi-module Maven project:

- **core** - Library module with its own `application.yml` (`greeting.message: "core"`)
- **app** - Application module that depends on core, with its own `application.yml` (`greeting.message: "app"`)

## Steps to Reproduce

1. Build and install all modules:

```bash
./mvnw clean install
```

2. Run the uber jar:

```bash
java -jar app/target/config-conflict-app-1.0-SNAPSHOT.jar
```

3. Call the endpoint:

```bash
curl http://localhost:8080/greetings
```

**Expected:** `app`

**Actual:** `core`

## Issue

When building an uber jar, both `application.yml` files from the core and app modules are included. The core module's configuration takes precedence over the app module's configuration, resulting in the wrong value being returned.
