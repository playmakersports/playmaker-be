package com.example.playmaker.service.match;

import com.example.playmaker.domain.match.Match;
import com.example.playmaker.web.match.dto.MatchForm;

public interface MatchService {

    Match createMatch(Long id, MatchForm matchForm);
}
