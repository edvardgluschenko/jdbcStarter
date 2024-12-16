package org.example.dto;

public record StudentFilter (int limit,
                             int offset,
                             Double gradeMathemetic,
                             String firstName){
}
