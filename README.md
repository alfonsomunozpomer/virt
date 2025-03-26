# Virt

You’ll want to set up your OpenAI API key. A quick way is to create an `.env` file in the root of the project with the following content:

```shell
OPENAI_API_KEY=your-api-key
```

Then you can add it as an environment variable like this:

```shell
source .env
```

Next run Quarkus in development mode:

```shell
quarkus dev
```

Or with Gradle:

```shell
./gradlew quarkusDev
```

Browse to `http://localhost:8080/virt/virt.html` to chat with Virt. If you browse to `http://localhost:8080/virt/` you can see the Vite Vue TS starter app.