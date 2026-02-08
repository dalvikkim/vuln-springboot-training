# OWASP Top 10 - 재현 가이드 (교육용)

## A01 Broken Access Control
- `GET /api/documents/{id}` : id만 바꿔서 다른 사용자 문서 조회 (IDOR)
- `GET /api/admin/users` : 인증만 하면 모든 사용자 목록 (역할 미검증)
- `GET /api/users/{id}` : 다른 사용자 프로필 조회

## A02 Cryptographic Failures
- data.sql / User 엔티티: 비밀번호 평문 저장
- SecurityConfig: NoOpPasswordEncoder 사용

## A03 Injection
- `GET /api/injection/user?name=' OR '1'='1` 등으로 SQL Injection 시도

## A05 Security Misconfiguration
- application.yml: include-message, include-stacktrace
- management.endpoints.web.exposure.include: "*"

## A10 SSRF
- `GET /api/ssrf/fetch?url=http://169.254.169.254/latest/meta-data/` (AWS 메타데이터 등 - 테스트 환경에서만)

## Docker 실행
- 빌드: mvn clean package
- 실행: docker-compose up --build
- 앱: http://localhost:8080
- H2 콘솔: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:testdb, user: sa, password: 빈칸)