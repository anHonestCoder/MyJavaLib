namespace app
{
    partial class WinForm
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要修改
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(WinForm));
            this.resultText = new System.Windows.Forms.RichTextBox();
            this.inputText = new System.Windows.Forms.RichTextBox();
            this.submit = new System.Windows.Forms.Button();
            this.clearAll = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.clearResult = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // resultText
            // 
            this.resultText.BackColor = System.Drawing.SystemColors.ControlLightLight;
            this.resultText.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.resultText.Location = new System.Drawing.Point(12, 27);
            this.resultText.Margin = new System.Windows.Forms.Padding(20, 0, 0, 0);
            this.resultText.Name = "resultText";
            this.resultText.ReadOnly = true;
            this.resultText.Size = new System.Drawing.Size(463, 145);
            this.resultText.TabIndex = 0;
            this.resultText.Text = "";
            this.resultText.MouseDown += new System.Windows.Forms.MouseEventHandler(this.resultText_MouseDown);
            // 
            // inputText
            // 
            this.inputText.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.inputText.Location = new System.Drawing.Point(12, 209);
            this.inputText.Margin = new System.Windows.Forms.Padding(0);
            this.inputText.Name = "inputText";
            this.inputText.ScrollBars = System.Windows.Forms.RichTextBoxScrollBars.Vertical;
            this.inputText.Size = new System.Drawing.Size(463, 189);
            this.inputText.TabIndex = 1;
            this.inputText.Text = "";
            this.inputText.MouseDown += new System.Windows.Forms.MouseEventHandler(this.inputText_MouseDown);
            // 
            // submit
            // 
            this.submit.Location = new System.Drawing.Point(400, 414);
            this.submit.Name = "submit";
            this.submit.Size = new System.Drawing.Size(75, 23);
            this.submit.TabIndex = 2;
            this.submit.Text = "汇总";
            this.submit.UseVisualStyleBackColor = true;
            this.submit.Click += new System.EventHandler(this.submit_button_click);
            // 
            // clearAll
            // 
            this.clearAll.Location = new System.Drawing.Point(110, 414);
            this.clearAll.Name = "clearAll";
            this.clearAll.Size = new System.Drawing.Size(75, 23);
            this.clearAll.TabIndex = 3;
            this.clearAll.Text = "清空全部";
            this.clearAll.UseVisualStyleBackColor = true;
            this.clearAll.Click += new System.EventHandler(this.clear_button_click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label1.Location = new System.Drawing.Point(12, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(77, 14);
            this.label1.TabIndex = 4;
            this.label1.Text = "汇总结果：";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label2.Location = new System.Drawing.Point(12, 187);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(91, 14);
            this.label2.TabIndex = 5;
            this.label2.Text = "请输入数据：";
            // 
            // clearResult
            // 
            this.clearResult.Location = new System.Drawing.Point(12, 414);
            this.clearResult.Name = "clearResult";
            this.clearResult.Size = new System.Drawing.Size(75, 23);
            this.clearResult.TabIndex = 6;
            this.clearResult.Text = "清空结果";
            this.clearResult.UseVisualStyleBackColor = true;
            this.clearResult.Click += new System.EventHandler(this.clearResult_Click);
            // 
            // WinForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(487, 444);
            this.Controls.Add(this.clearResult);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.clearAll);
            this.Controls.Add(this.submit);
            this.Controls.Add(this.inputText);
            this.Controls.Add(this.resultText);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.Name = "WinForm";
            this.Text = "汇总计算器";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        private void initDictionay()
        {
            this.dictionary = new System.Collections.Generic.Dictionary<string, int>();
            string itemKeysStr = System.Configuration.ConfigurationSettings.AppSettings["itemKeys"].ToString();
            string[] itemKeysArray = System.Text.RegularExpressions.Regex.Split(itemKeysStr, ";");
            foreach (string str in itemKeysArray)
            {
                string item = str.Trim();
                if(!item.Equals(""))
                {
                    dictionary.Add(item, 0);
                } 
            }
        }

        #endregion

        private System.Windows.Forms.RichTextBox resultText;
        private System.Windows.Forms.RichTextBox inputText;
        private System.Windows.Forms.Button submit;
        private System.Windows.Forms.Button clearAll;
        private System.Collections.Generic.Dictionary<string, int> dictionary;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button clearResult;
    }


}

