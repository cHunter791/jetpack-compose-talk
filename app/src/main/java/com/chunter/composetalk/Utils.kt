package com.chunter.composetalk

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat
import com.chunter.composetalk.data.Team

fun openUrl(context: Context, url: String) {
    val defaultBrowser =
        Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_BROWSER)
    defaultBrowser.data = Uri.parse(url)
    ContextCompat.startActivity(context, defaultBrowser, null)
}

val teamPreview = Team(
    id = 1,
    name = "Arsenal",
    description = "Arsenal Football Club is a professional football club based in Islington, London, England, that plays in the Premier League, the top flight of English football. The club has won 13 League titles, a record 13 FA Cups, 2 League Cups, 15 FA Community Shields, 1 League Centenary Trophy, 1 UEFA Cup Winners' Cup and 1 Inter-Cities Fairs Cup.\\r\\n\\r\\nArsenal was the first club from the South of England to join The Football League, in 1893, and they reached the First Division in 1904. Relegated only once, in 1913, they continue the longest streak in the top division, and have won the second-most top-flight matches in English football history. In the 1930s, Arsenal won five League Championships and two FA Cups, and another FA Cup and two Championships after the war. In 1970–71, they won their first League and FA Cup Double. Between 1989 and 2005, they won five League titles and five FA Cups, including two more Doubles. They completed the 20th century with the highest average league position.\\r\\n\\r\\nHerbert Chapman won Arsenal's first national trophies, but died prematurely. He helped introduce the WM formation, floodlights, and shirt numbers, and added the white sleeves and brighter red to the club's kit. Arsène Wenger was the longest-serving manager and won the most trophies. He won a record 7 FA Cups, and his title-winning team set an English record for the longest top-flight unbeaten league run at 49 games between 2003 and 2004, receiving the nickname The Invincibles.\\r\\n\\r\\nIn 1886, Woolwich munitions workers founded the club as Dial Square. In 1913, the club crossed the city to Arsenal Stadium in Highbury, becoming close neighbours of Tottenham Hotspur, and creating the North London derby. In 2006, they moved to the nearby Emirates Stadium. In terms of revenue, Arsenal is the ninth highest-earning football club in the world, earned €487.6m in 2016–17 season. Based on social media activity from 2014 to 2015, Arsenal's fanbase is the fifth largest in the world. In 2018, Forbes estimated the club was the third most valuable in England, with the club being worth \$2.24 billion.",
    alternateName = "Gunners, Arsenal Football Club, AFC",
    formationYear = 1892,
    badgeUrl = "https://www.thesportsdb.com/images/media/team/badge/a1af2i1557005128.png",
    websiteUrl = "www.arsenal.com",
    facebookUrl = "www.facebook.com/Arsenal",
    twitterUrl = "twitter.com/arsenal",
    instagramUrl = "instagram.com/arsenal"
)