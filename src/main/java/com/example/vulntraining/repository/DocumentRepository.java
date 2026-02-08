package com.example.vulntraining.repository;

import com.example.vulntraining.model.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    // A03 Injection: 파라미터 바인딩 없이 사용하면 취약 (아래는 안전한 예시)
    // 취약 버전은 InjectionController에서 네이티브 쿼리로 구현
    List<Document> findByTitleContaining(String title);
}