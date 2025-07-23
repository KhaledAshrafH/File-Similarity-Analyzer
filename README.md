<div align="center">

# 🔍 File Similarity Checker

<h3> Fast text file comparison tool with intelligent word matching algorithms</h3>

</div>

## About The Project

<div align="center">
  <img src="https://user-images.githubusercontent.com/placeholder/demo.gif" alt="Demo GIF" width="80%"/>
</div>

**File Similarity Checker** is a high-performance Spring Boot application designed to analyze and compare text files with precision and speed. Built with clean architecture principles, it provides a robust RESTful API for calculating similarity scores between a reference file and multiple target files.

### Why?

In today's digital world, comparing documents for similarity is crucial for:

- **Academic Integrity** - Detect plagiarism in student submissions
- **Content Management** - Identify duplicate content across documents
- **Quality Assurance** - Find similar bug reports or support tickets
- **Data Analysis** - Group similar documents for classification
- **Legal Compliance** - Compare contracts and legal documents

### How It Works

1. **Input** - Provide a reference text file and a directory of files to compare
2. **Processing** - Extract and normalize words from all files
3. **Analysis** - Calculate similarity scores using intelligent algorithms
4. **Output** - Get detailed JSON response with similarity percentages

---

## Features

<table>
<tr>
<td>

###  Core Features

- **Lightning Fast** - Process files in milliseconds
- **Accurate Scoring** - Advanced word matching algorithms
- **Smart Caching** - Caffeine cache for repeated comparisons
- **Scalable** - Handle files up to 50MB efficiently
- **Batch Processing** - Compare multiple files simultaneously
- **Detailed Reports** - Get comprehensive similarity metrics response

</td>
<td>

###  Technical Features

- **Clean Architecture** - Maintainable and testable code
- **RESTful API** - Standard HTTP endpoints
- **Spring Boot 3.5** - Latest framework features
- **Java 17** - Modern Java capabilities
- **100% Tested** - Comprehensive test coverage
- **Well Documented** - Clear API documentation

</td>
</tr>
</table>

---

## Technology Stack

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-ED8B00?style=flat-square&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/Spring%20Boot-3.5.3-6DB33F?style=flat-square&logo=springboot&logoColor=white" />
  <img src="https://img.shields.io/badge/Maven-3.6+-C71A36?style=flat-square&logo=apachemaven&logoColor=white" />
  <img src="https://img.shields.io/badge/Caffeine-3.2.2-FF6B6B?style=flat-square&logo=java&logoColor=white" />
  <img src="https://img.shields.io/badge/Lombok-1.18.30-BC2E20?style=flat-square&logo=lombok&logoColor=white" />
</p>

---

## API Endpoints

- `GET /api/v1/similarity/compare`
  - Compares all files in the directory to the reference file and returns similarity scores.

- `GET /api/v1/similarity/top/{count}`
  - Returns the top {count} files with the highest similarity scores to the reference file.

### Sample Output

```json
{
  "referenceFile": "reference.txt",
  "totalFilesCompared": 5,
  "results": [
    {
      "fileName": "exact-match.txt",
      "score": 100.0,
      "matchedWords": 521,
      "totalReferenceWords": 521,
      "similarityPercentage": "100.0%"
    },
    {
      "fileName": "high-match.txt",
      "score": 64.3,
      "matchedWords": 335,
      "totalReferenceWords": 521,
      "similarityPercentage": "64.3%"
    },
    {
      "fileName": "medium-match.txt",
      "score": 25.14,
      "matchedWords": 131,
      "totalReferenceWords": 521,
      "similarityPercentage": "25.14%"
    },
    {
      "fileName": "low-match.txt",
      "score": 16.7,
      "matchedWords": 87,
      "totalReferenceWords": 521,
      "similarityPercentage": "16.7%"
    },
    {
      "fileName": "no-match.txt",
      "score": 0.0,
      "matchedWords": 0,
      "totalReferenceWords": 521,
      "similarityPercentage": "0.0%"
    }
  ],
  "executionTime": "1 ms",
  "bestMatch": "exact-match.txt"
}
```
---

## Future Features

- **Multi-language Support**: Allow similarity checks for documents in multiple languages. This will enable the tool to process files written in different languages and enhance its applicability in multilingual environments.

- **Custom Algorithms**: Add support for user-defined comparison algorithms. Users will be able to implement their own algorithms to be used within the tool, providing flexibility and customization for specialized needs.

- **Real-time Updates**: WebSocket integration for real-time report updates. This will allow users to receive live updates on similarity checks, improving the responsiveness and interactivity of the application.

---

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/featureX`)
3. Commit your changes (`git commit -m 'Add some featureX'`)
4. Push to the branch (`git push origin feature/featureX`)
5. Open a Pull Request



## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

