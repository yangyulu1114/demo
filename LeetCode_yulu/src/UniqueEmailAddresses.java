import java.util.HashSet;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            String[] address = email.split("@");
            if (address[0].indexOf(".") != -1) {
                String[] locals = address[0].split("\\."); // 要注意转义
                for (String localname : locals) {
                    sb.append(localname);
                }
            } else {
                sb.append(address[0]);
            }
            int index = sb.indexOf("+");
            if (index != - 1) {
                sb.setLength(index);
            }
            sb.append("@").append(address[1]);
            set.add(sb.toString());
        }
        return set.size();
    }

    public int numUniqueEmails2(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for (String email : emails) {
            int index = email.indexOf("@");
            String local = email.substring(0, index);
            String rest = email.substring(index);
            if (local.indexOf("+") != -1) {
                local = local.substring(0, local.indexOf("+"));
            }
            local = local.replaceAll("\\.", "");
            set.add(local + rest);
        }
        return set.size();
    }

    public void test() {
        String[] emails = new String[] {"j+ezsorqlmc@rfpycgjuf.com",
                                        "j+k+ri+rigt.ad@rfpycgjuf.com",
                                        "hfmeqzk.isx+i@fiidmdrsu.com",
                                        "j+p+h+d+d+p+z.j.k.g@rfpycgjuf.com",
                                        "zygekdy.l.w+s@snh.owpyu.com",
                                        "j+m.l+ia+qdgv+w@rfpycgjuf.com",
                                        "r+hwbjwefkp@wcjaki.n.com",
                                        "zygekdy.l.w+d@snh.owpyu.com",
                                        "bizdm+sz.f.a.k@il.cjjlp.com",
                                        "hfmeqzk.isx+t@fiidmdrsu.com",
                                        "hfmeqzk.isx+i@fiidmdrsu.com",
                                        "bizdm+f+j+m.l.l@il.cjjlp.com",
                                        "zygekdy.l.w+g@snh.owpyu.com",
                                        "r+evgvxmksf@wcjaki.n.com",
                                        "hfmeqzk.isx+h@fiidmdrsu.com",
                                        "bizdm+lov+cy@il.cjjlp.com",
                                        "hfmeqzk.isx+o@fiidmdrsu.com",
                                        "bizdm+hs+qao@il.cjjlp.com",
                                        "r+v+z+rcuznrj@wcjaki.n.com",
                                        "j+r.kn+h.w.a.h+bh@rfpycgjuf.com",
                                        "hfmeqzk.isx+t@fiidmdrsu.com",
                                        "hfmeqzk.isx+a@fiidmdrsu.com",
                                        "zygekdy.l.w+o@snh.owpyu.com",
                                        "zygekdy.l.w+i@snh.owpyu.com",
                                        "r+vy.u.y+f.er+aw@wcjaki.n.com",
                                        "zygekdy.l.w+c@snh.owpyu.com",
                                        "bizdm+wztzg@il.cjjlp.com",
                                        "j+h.fwbsr+chp@rfpycgjuf.com",
                                        "zygekdy.l.w+s@snh.owpyu.com",
                                        "zygekdy.l.w+d@snh.owpyu.com",
                                        "bizdm+qq.o.q+p@il.cjjlp.com",
                                        "zygekdy.l.w+o@snh.owpyu.com",
                                        "j+c+zqbq+h.dyt@rfpycgjuf.com",
                                        "r+hl.b.i+fz.hz.t@wcjaki.n.com",
                                        "r+cbabpf.k+w+e@wcjaki.n.com"};
        String[] emails2 = new String[] {"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails2(emails2));
    }
}
