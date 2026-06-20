package com.example.androidonboardingstarter;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private static final int BACKGROUND = Color.rgb(246, 248, 251);
    private static final int CARD = Color.WHITE;
    private static final int TEXT = Color.rgb(30, 41, 59);
    private static final int MUTED = Color.rgb(100, 116, 139);
    private static final int ACCENT = Color.rgb(37, 99, 235);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scrollView = new ScrollView(this);
        scrollView.setBackgroundColor(BACKGROUND);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(dp(20), dp(22), dp(20), dp(22));
        scrollView.addView(root);

        root.addView(title("Onboarding and Environment Setup"));
        root.addView(subtitle("Android internship starter plan"));

        root.addView(section(
                "Objective",
                "Install Android Studio and SDKs\n"
                        + "Set up Git and GitHub\n"
                        + "Explore Android Studio tools\n"
                        + "Complete beginner Android tutorials"
        ));

        root.addView(section(
                "Days 1-2: Onboarding",
                "Attend company orientation\n"
                        + "Understand culture, workflow, and internship goals\n"
                        + "Meet team members and mentors\n"
                        + "Review project objectives and expectations"
        ));

        root.addView(section(
                "Days 3-5: Environment Setup",
                "Install Android Studio\n"
                        + "Configure Android SDK, emulator, and device settings\n"
                        + "Initialize GitHub repository\n"
                        + "Create sample Android project\n"
                        + "Document setup experience for LinkedIn"
        ));

        root.addView(section(
                "Sample Repository Deliverables",
                "Android Studio project initialized\n"
                        + "Git repository created\n"
                        + "README added with setup steps\n"
                        + "Sample onboarding screen implemented\n"
                        + "LinkedIn post draft prepared"
        ));

        root.addView(section(
                "LinkedIn Summary",
                "Completed my internship onboarding and Android environment setup. "
                        + "I explored Android Studio, configured SDK tools, set up GitHub, "
                        + "and built a sample app to document the first week of learning."
        ));

        setContentView(scrollView);
    }

    private TextView title(String text) {
        TextView view = new TextView(this);
        view.setText(text);
        view.setTextColor(TEXT);
        view.setTextSize(26);
        view.setTypeface(Typeface.DEFAULT_BOLD);
        view.setGravity(Gravity.START);
        view.setPadding(0, 0, 0, dp(6));
        return view;
    }

    private TextView subtitle(String text) {
        TextView view = new TextView(this);
        view.setText(text);
        view.setTextColor(MUTED);
        view.setTextSize(16);
        view.setPadding(0, 0, 0, dp(18));
        return view;
    }

    private View section(String heading, String body) {
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setBackgroundColor(CARD);
        card.setPadding(dp(16), dp(14), dp(16), dp(14));

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 0, 0, dp(12));
        card.setLayoutParams(params);

        TextView headingView = new TextView(this);
        headingView.setText(heading);
        headingView.setTextColor(ACCENT);
        headingView.setTextSize(18);
        headingView.setTypeface(Typeface.DEFAULT_BOLD);
        headingView.setPadding(0, 0, 0, dp(8));

        TextView bodyView = new TextView(this);
        bodyView.setText(body);
        bodyView.setTextColor(TEXT);
        bodyView.setTextSize(15);
        bodyView.setLineSpacing(dp(3), 1.0f);

        card.addView(headingView);
        card.addView(bodyView);
        return card;
    }

    private int dp(int value) {
        return (int) (value * getResources().getDisplayMetrics().density);
    }
}
