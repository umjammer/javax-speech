/*
 * Copyright (c) 2022 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package javax.speech;

import java.util.Arrays;
import java.util.Locale;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.speech.synthesis.Voice;

import org.junit.jupiter.api.Test;


class Test1 {

    @Test
    void test01() throws Exception {
        speak("She sells seashells by the seashore.");
    }

    void speak(String text) throws Exception {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        SynthesizerModeDesc desc = new SynthesizerModeDesc(Locale.US);
        Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
        Synthesizer synthesizer = Central.createSynthesizer(desc);

        synthesizer.allocate();
        synthesizer.resume();

        SynthesizerModeDesc smd = (SynthesizerModeDesc) synthesizer.getEngineModeDesc();
System.err.println("---- voices ----");
Arrays.stream(smd.getVoices()).forEach(v -> System.err.println(v.getName()));
System.err.println("---");
        String name = "kevin16";
//        String name = "kevin";
        Voice voice = Arrays.stream(smd.getVoices())
                .filter(v -> v.getName().equals(name))
                .findFirst().get();
        synthesizer.getSynthesizerProperties().setVoice(voice);
        synthesizer.getSynthesizerProperties().setVolume(0.5f); // 0.0 ~ 1.0

        synthesizer.speakPlainText(text, null);

        synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
        synthesizer.deallocate();
    }

}

/* */
