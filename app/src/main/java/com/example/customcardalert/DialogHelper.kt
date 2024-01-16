package com.example.customcardalert

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.ProgressBar
import android.widget.TextView
import androidx.viewbinding.ViewBinding
import com.example.customcardalert.databinding.CardAlertFailedBinding
import com.example.customcardalert.databinding.CardAlertSuccessBinding

class DialogHelper {

    companion object {

        fun cardAlertSuccess(activity: Activity, action: () -> Unit ) {
            val binding = CardAlertSuccessBinding.inflate(LayoutInflater.from(activity))
            val myCard = Dialog(activity)
            myCard.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myCard.setContentView(binding.root)

            animatedProgressBar(binding.progressBar, 100)

            binding.buttonCardContinue.setOnClickListener {
                action()
                delayHideCard(binding, myCard, 1000)
            }
            myCard.show()
        }

        fun cardAlertFailed(activity: Activity, action: () -> Unit ) {
            val binding = CardAlertFailedBinding.inflate(LayoutInflater.from(activity))
            val myCard = Dialog(activity)
            myCard.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myCard.setContentView(binding.root)

            animatedProgressBar(binding.progressBar, 67)
            animatedText(binding.textPercentage, 67)

            binding.buttonCardContinue.setOnClickListener {
                action()
                delayHideCard(binding, myCard, 2000)
            }
            myCard.show()
        }

        private fun delayHideCard(
            binding: ViewBinding,
            myCard: Dialog,
            timeMillis: Long
        ) {
            binding.root.postDelayed({
                myCard.cancel()
            }, timeMillis)
        }

        private fun animatedProgressBar(progressBar: ProgressBar, progress: Int) {
            val progressAnimator = ObjectAnimator.ofInt(progressBar, "progress", 0, progress)
            progressAnimator.duration = 1000
            progressAnimator.start()
        }

        private fun animatedText(textView: TextView, progress: Int) {
            val valueAnimator = ValueAnimator.ofInt(0, progress)
            valueAnimator.duration = 1000
            valueAnimator.addUpdateListener {
                val animatedValue = it.animatedValue as Int
                textView.text = animatedValue.toString()
            }
            valueAnimator.start()
        }
    }
}